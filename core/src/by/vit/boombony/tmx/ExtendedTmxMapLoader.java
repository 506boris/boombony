package by.vit.boombony.tmx;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.ImageResolver;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;

public class ExtendedTmxMapLoader extends TmxMapLoader {

    public ExtendedTiledMap load(String fileName) {
        return load(fileName, new TmxMapLoader.Parameters());
    }

    /**
     * Loads the {@link TiledMap} from the given file. The file is resolved via the {@link FileHandleResolver} set in the
     * constructor of this class. By default it will resolve to an internal file.
     *
     * @param fileName   the filename
     * @param parameters specifies whether to use y-up, generate mip maps etc.
     * @return the TiledMap
     */
    public ExtendedTiledMap load(String fileName, TmxMapLoader.Parameters parameters) {
        try {
            this.convertObjectToTileSpace = parameters.convertObjectToTileSpace;
            this.flipY = parameters.flipY;
            FileHandle tmxFile = resolve(fileName);
            root = xml.parse(tmxFile);
            ObjectMap<String, Texture> textures = new ObjectMap<String, Texture>();
            Array<FileHandle> textureFiles = loadTilesets(root, tmxFile);
            textureFiles.addAll(loadImages(root, tmxFile));

            for (FileHandle textureFile : textureFiles) {
                Texture texture = new Texture(textureFile, parameters.generateMipMaps);
                texture.setFilter(parameters.textureMinFilter, parameters.textureMagFilter);
                textures.put(textureFile.path(), texture);
            }

            ImageResolver.DirectImageResolver imageResolver = new ImageResolver.DirectImageResolver(textures);
            ExtendedTiledMap map = loadTilemap(root, tmxFile, imageResolver);
            map.setOwnedResources(textures.values().toArray());
            return map;
        } catch (IOException e) {
            throw new GdxRuntimeException("Couldn't load tilemap '" + fileName + "'", e);
        }
    }

    /**
     * Loads the map data, given the XML root element and an {@link ImageResolver} used to return the tileset Textures
     *
     * @param root          the XML root element
     * @param tmxFile       the Filehandle of the tmx file
     * @param imageResolver the {@link ImageResolver}
     * @return the {@link TiledMap}
     */
    protected ExtendedTiledMap loadTilemap(XmlReader.Element root, FileHandle tmxFile, ImageResolver imageResolver) {
        ExtendedTiledMap map = new ExtendedTiledMap();

        String mapOrientation = root.getAttribute("orientation", null);
        int mapWidth = root.getIntAttribute("width", 0);
        int mapHeight = root.getIntAttribute("height", 0);
        int tileWidth = root.getIntAttribute("tilewidth", 0);
        int tileHeight = root.getIntAttribute("tileheight", 0);
        int hexSideLength = root.getIntAttribute("hexsidelength", 0);
        String staggerAxis = root.getAttribute("staggeraxis", null);
        String staggerIndex = root.getAttribute("staggerindex", null);
        String mapBackgroundColor = root.getAttribute("backgroundcolor", null);

        MapProperties mapProperties = map.getProperties();
        if (mapOrientation != null) {
            mapProperties.put("orientation", mapOrientation);
        }
        mapProperties.put("width", mapWidth);
        mapProperties.put("height", mapHeight);
        mapProperties.put("tilewidth", tileWidth);
        mapProperties.put("tileheight", tileHeight);
        mapProperties.put("hexsidelength", hexSideLength);
        if (staggerAxis != null) {
            mapProperties.put("staggeraxis", staggerAxis);
        }
        if (staggerIndex != null) {
            mapProperties.put("staggerindex", staggerIndex);
        }
        if (mapBackgroundColor != null) {
            mapProperties.put("backgroundcolor", mapBackgroundColor);
        }
        mapTileWidth = tileWidth;
        mapTileHeight = tileHeight;
        mapWidthInPixels = mapWidth * tileWidth;
        mapHeightInPixels = mapHeight * tileHeight;

        if (mapOrientation != null) {
            if ("staggered".equals(mapOrientation)) {
                if (mapHeight > 1) {
                    mapWidthInPixels += tileWidth / 2;
                    mapHeightInPixels = mapHeightInPixels / 2 + tileHeight / 2;
                }
            }
        }

        XmlReader.Element properties = root.getChildByName("properties");
        if (properties != null) {
            loadProperties(map.getProperties(), properties);
        }
        Array<XmlReader.Element> tilesets = root.getChildrenByName("tileset");
        for (XmlReader.Element element : tilesets) {
            loadTileSet(map, element, tmxFile, imageResolver);
            root.removeChild(element);
        }
        for (int i = 0, j = root.getChildCount(); i < j; i++) {
            XmlReader.Element element = root.getChild(i);
            loadLayer(map, map.getLayers(), element, tmxFile, imageResolver);
        }
        return map;
    }


}

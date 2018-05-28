package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.screens.HasTileMap;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {
    private OrthogonalTiledMapRenderer renderer;
    private WorldScreen worldScreen;
    private Batch batch;
    private OrthographicCamera camera;
    private OrthographicCamera cameraHUD;
    private TiledMapTileLayer objectLayer;
    private TiledMapTileLayer groundLayer;
    private int layerWidth = 0;
    private int layerHeight = 0;
    private HasTileMap hasTileMap;
    private HUDStage hudStage;

    public WorldRenderer(WorldScreen worldScreen, HUDStage hudStage) {
        this.worldScreen = worldScreen;
        this.hudStage = hudStage;
        this.hasTileMap = (WorldTxLibrary) worldScreen.getTxLibrary();
    }

    void init() {
        renderer = new OrthogonalTiledMapRenderer(hasTileMap.getTiledMap());
        // camera
        camera = new OrthographicCamera(Const.CAMERA_WIDTH, Const.CAMERA_HEIGHT);
        camera.setToOrtho(false);
        camera.update();

        // cameraHUD
        cameraHUD = new OrthographicCamera(Const.CAMERA_WIDTH, Const.CAMERA_HEIGHT);
        cameraHUD.position.set(0, 0, 0);
        cameraHUD.setToOrtho(false);
        cameraHUD.update();

        this.batch = renderer.getBatch();

        this.groundLayer = hasTileMap.getLayer(WorldLayerType.GROUND);
        this.objectLayer = hasTileMap.getLayer(WorldLayerType.OBJECTS);
        this.layerWidth = groundLayer.getWidth() * Const.TILE_SIZE;
        this.layerHeight = groundLayer.getHeight() * Const.TILE_SIZE;

    }

    public void render(float delta) {
        worldScreen.hero.render(delta, objectLayer);

        CameraHelper.followCamera(camera, worldScreen.hero, layerWidth, layerHeight);

        if (renderer != null) {
            renderer.setView(camera);
            renderer.render();
        }

        renderHUD(delta);
    }

    private void renderHUD(float delta) {
        batch.setProjectionMatrix(cameraHUD.combined);
        hudStage.update(delta);
        hudStage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}

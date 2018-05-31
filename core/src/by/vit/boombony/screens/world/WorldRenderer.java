package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.Initializable;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.screens.HasTileMap;
import by.vit.boombony.screens.ScreenManager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable, Initializable {
    private OrthogonalTiledMapRenderer renderer;
    private WorldScreen worldScreen;
    private Batch batch;
    private OrthographicCamera camera;
    private OrthographicCamera cameraHUD;
    private TiledMapTileLayer objectLayer;
    private TiledMapTileLayer groundLayer;
    private int mapWidth = 0;
    private int mapHeight = 0;
    private HUDStage hudStage;
    private ScreenManager screenManager;

    public WorldRenderer(WorldScreen worldScreen, ScreenManager screenManager, HUDStage hudStage) {
        this.worldScreen = worldScreen;
        this.screenManager = screenManager;
        this.hudStage = hudStage;
    }

    @Override
    public void init() {
        HasTileMap hasTileMap = (WorldTxLibrary) worldScreen.getTxLibrary();
        renderer = new OrthogonalTiledMapRenderer(hasTileMap.getTiledMap(), screenManager.getGame().getBatch());

        // camera
        camera = new OrthographicCamera(Const.CAMERA_WIDTH, Const.CAMERA_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.setToOrtho(false);

        // cameraHUD
        cameraHUD = new OrthographicCamera(Const.CAMERA_WIDTH, Const.CAMERA_HEIGHT);
        cameraHUD.position.set(0, 0, 0);
        cameraHUD.setToOrtho(false);

        this.batch = renderer.getBatch();

        this.groundLayer = hasTileMap.getLayer(WorldLayerType.GROUND);
        this.objectLayer = hasTileMap.getLayer(WorldLayerType.OBJECTS);
        this.mapWidth = groundLayer.getWidth() * Const.TILE_SIZE;
        this.mapHeight = groundLayer.getHeight() * Const.TILE_SIZE;

    }

    public void render(float delta) {
        worldScreen.hero.render(delta, objectLayer);

        CameraHelper.followCamera(camera, worldScreen.hero, mapWidth, mapHeight);

        if (renderer != null) {
            renderer.setView(camera.combined, 0, 0, camera.viewportWidth, camera.viewportHeight);
            renderer.render();
        }

        renderHUD(delta);
    }

    private void renderHUD(float delta) {
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

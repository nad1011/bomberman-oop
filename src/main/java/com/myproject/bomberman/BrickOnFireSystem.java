package com.myproject.bomberman;

import java.util.List;

public class BrickOnFireSystem extends System {

    @Override
    public void update(double tpf) {
        List<Entity> entityList = getParentWorld().getEntitiesByType(
                TransformComponent.class,
                BrickOnFireComponent.class
        );
        TerrainComponent terrain = getParentWorld().getSingletonComponent(TerrainComponent.class);
        TerrainUtility system = getParentWorld().getSystem(TerrainUtility.class);

        for (Entity brick : entityList) {
            BrickOnFireComponent timer = brick.getComponentByType(BrickOnFireComponent.class);
            TransformComponent transform = brick.getComponentByType(TransformComponent.class);

            if (timer.isFinished()) {
                int rowIndex = terrain.getRowIndex(transform.getY());
                int columnIndex = terrain.getColumnIndex(transform.getX());

                getParentWorld().removeEntityComponents(brick);
                Tile tile = terrain.getTile(rowIndex, columnIndex);
                system.resetTile(rowIndex, columnIndex);
                switch (tile) {
                    case UNEXPOSED_PORTAL -> system.spawnPortal(rowIndex, columnIndex);
                    case UNEXPOSED_BOMB_ITEM -> system.spawnItem(rowIndex, columnIndex, Item.BOMB);
                    case UNEXPOSED_FLAME_ITEM -> system.spawnItem(rowIndex, columnIndex, Item.FLAME);
                    case UNEXPOSED_SPEED_ITEM -> system.spawnItem(rowIndex, columnIndex, Item.SPEED);
                }
            }
        }
    }
}

package com.myproject.bomberman.components;

public enum Tile {
    GRASS,
    WALL,
    BRICK,
    PORTAL,
    UNEXPOSED_PORTAL,
    BOMB_ITEM,
    UNEXPOSED_BOMB_ITEM,
    FLAME_ITEM,
    UNEXPOSED_FLAME_ITEM,
    SPEED_ITEM,
    UNEXPOSED_SPEED_ITEM,
    BOMB,
    FLAME;

    public boolean isItem() {
        return this == Tile.BOMB_ITEM || this == Tile.FLAME_ITEM || this == Tile.SPEED_ITEM;
    }
}

package io.giodude.baccaratnhcaobil.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VariationModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("game_name")
    @Expose
    private String gameName;
    @SerializedName("game_menu")
    @Expose
    private String gameMenu;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;

    public VariationModel(Integer id, String gameName, String gameMenu, String subtitle, String description, String image) {
        this.id = id;
        this.gameName = gameName;
        this.gameMenu = gameMenu;
        this.subtitle = subtitle;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameMenu() {
        return gameMenu;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}

package felipersn.com.br.materialdesign.Model;

import android.graphics.Bitmap;

/**
 * Created by Felipe Silveira on 3/11/2017.
 */

public class CardviewModel {
    private String title;
    private String description;
    private Bitmap icon;

    public CardviewModel(String title, String description, Bitmap icon) {
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}

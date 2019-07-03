package com.gluonapplication;

import com.gluonapplication.alternate.TestView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {

    @Override
    public void init() {
    	//first try with dragboard..failure
       // addViewFactory(HOME_VIEW, BasicView::new);
        
        //alternative implementation
        addViewFactory(HOME_VIEW, TestView::new);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }
}

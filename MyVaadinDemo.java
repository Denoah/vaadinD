package com;


import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class MyVaadinDemo extends UI {


    private Tree tree;
    private MenuBar menuBar;


    private void createTree(String caption) {
        tree = new Tree(caption);

        tree.addItem("1");
        tree.addItem("12");
        tree.addItem("13");
        tree.addItem("14");
        tree.addItem("2");
        tree.addItem("21");
        tree.addItem("22");
        tree.addItem("3");
        tree.setParent("12", "1");
        tree.setParent("13", "1");
        tree.setParent("14", "1");
        tree.setParent("21", "2");
        tree.setParent("22", "2");

        tree.setChildrenAllowed("12", false);
        tree.setChildrenAllowed("13", false);
        tree.setChildrenAllowed("14", false);
        tree.setChildrenAllowed("21", false);
        tree.setChildrenAllowed("22", false);
        tree.setChildrenAllowed("3", false);

    }

    private void createPanel(VerticalLayout currentLoyout) {
        Panel panel = new Panel();
        panel.setSizeFull();

        VerticalSplitPanel vsplit = new VerticalSplitPanel();
        vsplit.setSplitPosition(20, Unit.PIXELS);
        vsplit.setLocked(true);
        panel.setContent(vsplit);
        vsplit.setFirstComponent(menuBar);
        HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
        hsplit.setSplitPosition(200, Unit.PIXELS);
        HorizontalSplitPanel hsplit2 = new HorizontalSplitPanel();
        hsplit2.setSplitPosition(70, Unit.PERCENTAGE);

        vsplit.setSecondComponent(hsplit);
        hsplit.setFirstComponent(tree);
        hsplit.setSecondComponent(hsplit2);
        currentLoyout.addComponent(panel);

    }

    private void  initAll(VerticalLayout currentLoyout) {
        createTree("Tree's Name");
        createMenu(currentLoyout);
        createPanel(currentLoyout);
    }

    private void createMenu(VerticalLayout currentLoyout) {
        menuBar = new MenuBar();
        menuBar.setWidth(100, Unit.PERCENTAGE);

        MenuBar.MenuItem fileMenu = menuBar.addItem("File", null, null);
        MenuBar.MenuItem fileMenuContent = fileMenu.addItem("Edit", null, null);

        menuBar.addItem("Edit", null, null);
        menuBar.addItem("Exit", null, null);

    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        initAll(layout);


        setContent(layout);


    }
}

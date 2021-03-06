package app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.entities.LoginUser;
import constants.Constants;
import app.utils.Common;
import app.views.LoginView;
import app.views.MainMenuView;

public class LoginController {
	private MainMenuView mainMenuView;
    private LoginView loginView;
    private Constants constants;
    private Common commonUtil;

    public LoginController(LoginView view) {
        this.commonUtil = new Common();
        this.constants = new Constants();
        this.loginView = view;
        view.addLoginListener(new LoginListener());
    }
    public void showLoginView() {
        loginView.setVisible(true);
    }
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginUser user = loginView.getUser();
            if (commonUtil.checkUserLogin(user) == true) {
            	MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            	mainMenuController.showMainMenuView();
                loginView.setVisible(false);
            } else {
            	loginView.setVisible(true);
                loginView.showMessage(constants.loginErrorMessage);
            }
        }
    }
}

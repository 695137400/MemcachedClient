package com.cxy.redisclient.presentation.console;

import com.cxy.redisclient.integration.I18nFile;
import com.cxy.redisclient.presentation.RedisClient;
import org.eclipse.jface.dialogs.MessageDialog;

public class QuitCmd extends Command {
    private boolean quit;

    public QuitCmd(Console console, String cmd) {
        super(console, cmd);
        this.quit = false;
    }

    @Override
    public void execute() {
        boolean ok = MessageDialog.openConfirm(console.getTabFolder().getShell(), RedisClient.i18nFile.getText(I18nFile.QUITCONSOLE), RedisClient.i18nFile.getText(I18nFile.CONSOLECLOSED));
        if (ok) {
            quit = true;
            super.execute();
            console.quit();
        }

    }

    @Override
    public boolean canContinue() {
        return !quit;
    }

}

package ru.ifmo.droid2016.korchagin.multicheckin.utils;

import java.util.Map;
import java.util.Vector;

import ru.ifmo.droid2016.korchagin.multicheckin.MainApplication;
import ru.ifmo.droid2016.korchagin.multicheckin.integration.FacebookIntegration;
import ru.ifmo.droid2016.korchagin.multicheckin.integration.OkIntegration;
import ru.ifmo.droid2016.korchagin.multicheckin.integration.SocialIntegration;
import ru.ifmo.droid2016.korchagin.multicheckin.integration.TwitterIntegration;
import ru.ifmo.droid2016.korchagin.multicheckin.integration.VKIntegration;

public class IntegrationsUtil {

    public static Vector<SocialIntegration> getAllIntegrations() {
        Vector<SocialIntegration> vector = new Vector<>();

        vector.addElement(FacebookIntegration.getInstance());
        vector.addElement(VKIntegration.getInstance());
        vector.addElement(TwitterIntegration.getInstance());
        vector.addElement(OkIntegration.getInstance());
        // TODO  добавить сюда все Integration-ы

        return vector;
    }

    public static Vector<SocialIntegration> getSelectedIntegrations() {
        Vector<SocialIntegration> vector = getAllIntegrations();
        Vector<SocialIntegration> result = new Vector<>();
        Map<String, Integer> map = MainApplication.selectedSocialIntegrations;

        for (SocialIntegration w : vector) {
            Integer res = map.get(w.getNetworkName());
            if ((res != null) && (res == 1)) {
                result.addElement(w);
            }
        }
        return result;
    }
}

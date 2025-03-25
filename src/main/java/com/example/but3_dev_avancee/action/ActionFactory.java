package com.example.but3_dev_avancee.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put("action-debut.do", new ActionDebut());
        actions.put("actionUn.do", new ActionUn());
        actions.put("login-action.do", new LoginAction());
        actions.put("logout-action.do", new LogoutAction());
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}

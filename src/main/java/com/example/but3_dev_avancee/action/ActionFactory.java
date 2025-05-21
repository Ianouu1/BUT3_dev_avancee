package com.example.but3_dev_avancee.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Action> actions = new HashMap<>();

    static {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            InputStream inputStream = ActionFactory.class.getClassLoader().getResourceAsStream("myFactory.xml");

            if (inputStream == null) {
                throw new RuntimeException("Le fichier myFactory.xml est introuvable dans le classpath");
            }

            JsonNode root = xmlMapper.readTree(inputStream);
            JsonNode actionNodes = root.get("action");

            if (actionNodes.isArray()) {
                for (JsonNode actionNode : actionNodes) {
                    String key = actionNode.get("action-key").asText();
                    String value = actionNode.get("action-value").asText();

                    Class<?> ActionClass = Class.forName(value);
                    Action action = (Action) ActionClass.getDeclaredConstructor().newInstance();
                    actions.put(key, action);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'initialisation des actions", e);
        }
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}

package simclass;

import jade.lang.acl.ACLMessage;
import jade.core.Agent;

public class UIHelper {
    private static ClassroomUI ui;
    private static Agent proxyAgent;

    // Relier l'UI
    public static void setUI(ClassroomUI uiRef) {
        ui = uiRef;
    }

    // Créer un proxy agent (Teacher comme relais)
    public static void setAgent(Agent a) {
        proxyAgent = a;
    }

    // Envoyer un message
    public static void sendMessage(ACLMessage msg) {
        if (proxyAgent != null) {
            proxyAgent.send(msg);
        }
    }

    // Afficher dans l’UI
    public static void displayMessage(String sender, String content) {
        if (ui != null) {
            ui.addMessage(sender, content);
        }
    }
}

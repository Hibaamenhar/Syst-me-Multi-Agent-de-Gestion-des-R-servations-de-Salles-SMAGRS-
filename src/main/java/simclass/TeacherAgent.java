package simclass;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class TeacherAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Teacher prêt !");
        UIHelper.setAgent(this); // connecter au UIHelper

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent();
                    ACLMessage reply = msg.createReply();

                    if (content.toLowerCase().contains("bonjour")) {
                        reply.setContent("Bonjour ! Aujourd’hui nous parlons d’Intelligence Artificielle.");
                    } else if (content.toLowerCase().contains("exemple")) {
                        reply.setContent("Exemple : les assistants vocaux comme Siri ou Alexa.");
                    } else {
                        reply.setContent("Bonne question : " + content);
                    }

                    send(reply);
                    UIHelper.displayMessage("Teacher", reply.getContent());
                } else {
                    block();
                }
            }
        });
    }
}

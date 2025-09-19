package simclass;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AssistantAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Assistant prêt !");
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Je suis l’Assistant : courage, tu progresses bien !");
                    send(reply);
                    UIHelper.displayMessage("Assistant", reply.getContent());
                } else {
                    block();
                }
            }
        });
    }
}

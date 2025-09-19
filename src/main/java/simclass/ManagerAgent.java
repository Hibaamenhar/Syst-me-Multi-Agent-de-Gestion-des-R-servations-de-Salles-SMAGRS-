package simclass;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class ManagerAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Manager prêt !");
        addBehaviour(new TickerBehaviour(this, 10000) {
            protected void onTick() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(getAID("Assistant"));
                msg.setContent("Encourage l’étudiant !");
                send(msg);
                UIHelper.displayMessage("Manager", "Encourage l’étudiant !");
            }
        });
    }
}

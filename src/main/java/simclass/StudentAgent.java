package simclass;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class StudentAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("Student prêt !");
        addBehaviour(new TickerBehaviour(this, 15000) { // toutes les 15 sec
            protected void onTick() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(getAID("Teacher"));
                msg.setContent("Pouvez-vous donner un exemple ?");
                send(msg);
                UIHelper.displayMessage("Student", "Pouvez-vous donner un exemple ?");
            }
        });
    }
}

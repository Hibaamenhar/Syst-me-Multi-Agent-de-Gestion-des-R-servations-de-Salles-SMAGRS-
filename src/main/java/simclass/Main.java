package simclass;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.instance();
            Profile p = new ProfileImpl();
            ContainerController cc = rt.createMainContainer(p);

            // Création des agents
            AgentController teacher = cc.createNewAgent("Teacher", "simclass.TeacherAgent", null);
            AgentController assistant = cc.createNewAgent("Assistant", "simclass.AssistantAgent", null);
            AgentController student = cc.createNewAgent("Student", "simclass.StudentAgent", null);
            AgentController manager = cc.createNewAgent("Manager", "simclass.ManagerAgent", null);

            teacher.start();
            assistant.start();
            student.start();
            manager.start();

            // Lancer l'interface Swing
            javax.swing.SwingUtilities.invokeLater(() -> {
                ClassroomUI ui = new ClassroomUI();
                UIHelper.setUI(ui); // relier UI aux agents
                ui.setVisible(true);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

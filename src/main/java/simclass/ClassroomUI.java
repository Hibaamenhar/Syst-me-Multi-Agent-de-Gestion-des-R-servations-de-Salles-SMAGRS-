package simclass;

import javax.swing.*;
import java.awt.*;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class ClassroomUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ClassroomUI() {
        setTitle("SimClass - JADE + Swing");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Envoyer");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String text = inputField.getText();
        if (text.isEmpty()) return;

        chatArea.append("Vous: " + text + "\n");
        inputField.setText("");

        // Créer et envoyer un message JADE au Teacher
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("Teacher", AID.ISLOCALNAME));
        msg.setContent(text);

        UIHelper.sendMessage(msg);
    }

    // Affichage des réponses des agents
    public void addMessage(String sender, String content) {
        chatArea.append(sender + ": " + content + "\n");
    }
}

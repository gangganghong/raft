package V1;

import java.io.IOException;

public class RequestVoteTask extends MyTask {

    public RequestVoteTask(Node node) {
        super(node);
    }

    @Override
    public void start() throws IOException {
//        System.out.println("RequestVoteTask\t" + System.currentTimeMillis() + "\t" + node.getState());
        int oldTerm = node.getTerm();
        int newTerm = oldTerm + 1;
        node.setTerm(newTerm);
        Packet packet = new Packet();
        packet.setTerm(newTerm);
        packet.setType(MessageType.REQUEST_VOTE);
        packet.setMessage("packet for me");
        packet.setHost("127.0.0.1");
        packet.setPort(node.getPort());

        node.sendRequestVote(packet);
        node.setVoteCounter(1);
        node.setVoted(true);
    }
}

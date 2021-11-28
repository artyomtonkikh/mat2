import jade.core.Agent;
import java.util.ArrayList;

public class myagent extends Agent {
    double number;
    int iteration=0;
    public ArrayList<String> nodes;
    @Override
    protected void setup() {
        super.setup();
        Object[] args = getArguments();
        number = Double.valueOf((String) args[0]);
        String agent_consider=getLocalName();
        char[] index=new char[agent_consider.length()-5];
        agent_consider.getChars(5, agent_consider.length(), index, 0);
        ArrayList<String> agentnodes=new ArrayList<>();
        for (int i=1;i<args.length ;i++) {
            agentnodes.add((String) args[i]);
        }
        nodes=agentnodes;
        System.out.println(getLocalName()+" has number "+number+" has nodes "+nodes);
        addBehaviour(new mybehaviour(this));

    }
    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("work is done");
    }
}

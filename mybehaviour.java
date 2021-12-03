import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class mybehaviour extends Behaviour {
    boolean is_alive = false;
    double alpha=1.0/3.0;
    myagent agent;
    mybehaviour(myagent agent){
        this.agent=agent;
    }
    @Override
    public void action() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(agent.iteration>=10){
            getNumber();
        }
        //agent.iteration++;
        getMessages();
        for (int i=0;i<agent.nodes.size();i++){
            ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
            msg.addReceiver(new AID("agent"+String.valueOf(agent.nodes.get(i)), AID.ISLOCALNAME));
            Random rand = new Random();
            double noise=rand.nextGaussian();
            msg.setContent(String.valueOf(agent.number+noise));
            if(Math.random()<0.8)
                agent.send(msg);
        }
    }

    @Override
    public boolean done() {
        return is_alive;
    }
    protected void getMessages(){
        if(Math.random()<0.3){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
        //is_alive = false;
        ACLMessage msg=agent.receive();
        Double summ=0.0;
        while(msg!=null) {
            String message=msg.getContent();
            summ+= Double.valueOf(message)-agent.number;
            msg=agent.receive();
        }
        agent.iteration++;
        agent.number+=summ*alpha;
    }

    private void getNumber() {
        System.out.println("!!!!!!!!!!!!!!!!!!"+agent.getLocalName()+" got "+agent.number+"!!!!!!!!!!!!!!!!!!");
        is_alive=true;
    }
}

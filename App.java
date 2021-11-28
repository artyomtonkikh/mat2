import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class App {
    public static void main(String[] args) {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        profile.setParameter(Profile.MAIN_PORT, "10098");
        profile.setParameter(Profile.GUI, "true");
        ContainerController container = runtime.createMainContainer(profile);
        try {
            Object[] a1 = {"8", "2", "5"},
                    a2 = {"22", "1", "3"},
                    a3 = {"15", "2", "4"},
                    a4 = {"5", "3", "5"},
                    a5 = {"0", "1", "4"};
            AgentController ag1 = container.createNewAgent("agent1", "myagent", a1),
                    ag2 = container.createNewAgent("agent2", "myagent", a2),
                    ag3 = container.createNewAgent("agent3", "myagent", a3),
                    ag4 = container.createNewAgent("agent4", "myagent", a4),
                    ag5 = container.createNewAgent("agent5", "myagent", a5);
            ag1.start();
            ag2.start();
            ag3.start();
            ag4.start();
            ag5.start();
        } catch (Exception e) {};
    }
}
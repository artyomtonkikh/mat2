Класс агент описан в файле myagent.java  
Класс поведения агента описан в файле mybehaviour.java  
Запускается в файле App.java  
Написан в среде IntelliJ  
Перед запуском нужно в файле App.java прописать агентов в строке 15 в следующем формате:  
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
В этом примере создадутся 5 агентов с числами 8, 22, 15, 5, 0 и соседями [2, 5], [1, 3], [2, 4], [3, 5], [1, 4] соответственно.  
В качестве помех в сообщениях выбрана случайная величина гауссовского распределения со средним 0 и дисперсией 1.  
В качестве критерия отправки сообщения выбрана случайная величина с равномерным распределением от 0 до 1: если случайная величина приняла значение <0.8, то сообщение отправляется.  
При работе в консоль будут выводиться сообщения типа:  
agent1 has number 8.0 has nodes [2, 5] -- это сообщение о том, что agent1 хранит число 8 и имеет соседей 2 и 5  
!!!!!!!!!!!!!!!!!!agent1 got 11.60139953823339!!!!!!!!!!!!!!!!!! -- это сообщение о том, какое число в итоге имеет agent1 после алгоритма локального голосования

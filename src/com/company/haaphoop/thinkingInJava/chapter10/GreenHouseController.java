package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/4 22:39
 * @Modified:
 */
public class GreenHouseController extends Controller {
    /*
    * 注意，light、water、thermostat都属于外围类GreenHouseControls，而这些内部类能够自由地访问那些字段，
    * 无需限定条件或特殊许可。而且，action()方法通常都涉及对某种硬件的控制。
    * 大多数Event看起来都很相似，但是Bell和Restart则比较特别。Bell控制响铃，然后在事件列表中增加一个Bell对象
    * ，于是过一会儿它可以再次响铃。读者可能注意到了内部类是多么像多重继承：Bell和Restart有Event的所有方法
    * ，并且似乎也拥有外围类GreenHouseControls的所有方法。一个由Event对象组成的数组被递交给Restart，该数组
    * 要加到控制器上。由于Restart也是一个Event对象，所以同样可以将Restart对象添加到Restart.action()中，以使系统
    * 能够有规律地重新启动自己。
    *
    *
    * */
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Water is off";
        }
    }

    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event event: eventList) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event: eventList) {
                addEvent(event);
            }
            start();
            //TODO:
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime){super(delayTime);}

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public static void main(String[] args) {
        GreenHouseController greenHouseController = new GreenHouseController();
        greenHouseController.addEvent(greenHouseController.new Bell(900));
        Event[] eventList = {
                greenHouseController.new ThermostatNight(0),
                greenHouseController.new LightOn(200),
                greenHouseController.new LightOff(400),
                greenHouseController.new WaterOn(600),
                greenHouseController.new WaterOff(800),
                greenHouseController.new ThermostatDay(1400)
        };
        greenHouseController.addEvent(greenHouseController.new Restart(2000, eventList));
        if (args.length == 1) {
            greenHouseController.addEvent(new GreenHouseController.Terminate(new Integer(args[0])));
        }
        greenHouseController.run();
    }
}

package lesson6;

public class Noutbook {
    private String name;
    private String processor;
    private Integer ram;
    private String typeHdd;
    private Integer hdd;
    private String os;
    private String color;

    public Noutbook(String name, String processor, Integer ram, String typeHdd, Integer hdd, String os, String color) {
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.typeHdd = typeHdd;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getTypeHdd() {
        return typeHdd;
    }

    public void setTypeHdd(String typeHdd) {
        this.typeHdd = typeHdd;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){

            String outText = this.name + "\n"
            + "     " + this.processor + ", " + this.ram.toString() + "Gb, " 
            + this.hdd.toString() + "Gb " + this.typeHdd 
            + ", OS " + this.os + ", цвет: " + this.color;
        return outText;
    }
}

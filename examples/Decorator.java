// --------------
// Decorator.java
// --------------

interface Drawable {
    public String draw ();}

class Window implements Drawable {
    public String draw () {
        return "Window.draw()";}}

class DrawableDecorator implements Drawable {
    private Drawable _d;
    private String   _s;

    public DrawableDecorator (Drawable d, String s) {
        _d = d;
        _s = s;}

    public String draw () {
        return _s + " " + _d.draw();}}

final class Decorator {
    public static void main (String[] args) {
        System.out.println("Decorator.java");

        Drawable w = new Window();
        assert w.draw() == "Window.draw()";

        w = new DrawableDecorator(w, "Decoration1");
        assert w.draw().equals("Decoration1 Window.draw()");

        w = new DrawableDecorator(w, "Decoration2");
        assert w.draw().equals("Decoration2 Decoration1 Window.draw()");

        w = new DrawableDecorator(w, "Decoration3");
        assert w.draw().equals("Decoration3 Decoration2 Decoration1 Window.draw()");

        System.out.println("Done.");}}

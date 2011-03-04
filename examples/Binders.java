// ------------
// Binders.java
// ------------

interface UnaryFunction<T> {
    T call (T x);}

interface BinaryFunction<T> {
    T call (T x, T y);}

final class Minus implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x - y;}}

final class Bind1st<T> implements UnaryFunction<T> {
    private BinaryFunction<T> _bf;
    private T                 _x;

    public Bind1st (BinaryFunction<T> bf, T x) {
        _bf = bf;
        _x  = x;}

    public T call (T y) {
        return _bf.call(_x, y);}}

final class Bind2nd<T> implements UnaryFunction<T> {
    private BinaryFunction<T> _bf;
    private T                 _y;

    public Bind2nd (BinaryFunction<T> bf, T y) {
        _bf = bf;
        _y  = y;}

    public T call (T x) {
        return _bf.call(x, _y);}}

final class Binders {
    public static void main (String[] args) {
        System.out.println("Binders.java");

        final Bind1st<Integer> f = new Bind1st<Integer>(new Minus(), 3);
        assert f.call(2) == 1;

        final Bind2nd<Integer> g = new Bind2nd<Integer>(new Minus(), 3);
        assert g.call(2) == -1;

        System.out.println("Done.");}}

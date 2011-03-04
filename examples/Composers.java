// --------------
// Composers.java
// --------------

interface UnaryFunction<T> {
    T call (T x);}

interface BinaryFunction<T> {
    T call (T x, T y);}

final class Plus implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x + y;}}

final class Mult implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x * y;}}

final class Bind2nd<T> implements UnaryFunction<T> {
    private BinaryFunction<T> _bf;
    private T                 _y;

    public Bind2nd (BinaryFunction<T> bf, T y) {
        _bf = bf;
        _y  = y;}

    public T call (T x) {
        return _bf.call(x, _y);}}

final class Compose<T> implements UnaryFunction<T> {
    private UnaryFunction<T> _f;
    private UnaryFunction<T> _g;

    public Compose (UnaryFunction<T> f, UnaryFunction<T> g) {
        _f = f;
        _g = g;}

    public T call (T x) {
        return _f.call(_g.call(x));}}

final class Composers {
    public static void main (String[] args) {
        System.out.println("Composers.java");

        final Compose<Integer> f =
            new Compose<Integer>(
                new Bind2nd<Integer>(new Plus(), 1),
                new Bind2nd<Integer>(new Mult(), 3));

        assert f.call(5) == 16;

        System.out.println("Done.");}}

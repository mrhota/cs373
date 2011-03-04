// ------------
// Composers.js
// ------------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

function plus (x, y) {
    return x + y;}

function multiplies (x, y) {
    return x * y;}

function bind2nd (bf, y) {
    return function (x) {return bf(x, y);}}

function compose (f, g) {
    return function (x) {return f(g(x));}}

print("Composers.js\n");

var f = compose(bind2nd(plus, 1), bind2nd(multiplies, 3));
assert(f(5) == 16);

print("Done.\n");

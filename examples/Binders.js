// ------------
// Binders.js
// ------------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

function minus (x, y) {
    return x - y;}

function bind1st (bf, x) {
    return function (y) {return bf(x, y);}}

function bind2nd (bf, y) {
    return function (x) {return bf(x, y);}}

print("Binders.js\n");

var f = bind1st(minus, 3);
assert(f(2) == 1);

var g = bind2nd(minus, 3);
assert(g(2) == -1);

print("Done.\n");

// ---------
// Reduce.js
// ---------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

function plus (x, y) {
    return x + y;}

function multiplies (x, y) {
    return x * y;}

function reduce (bf, a, v) {
    for (var i in a)
        v = bf(v, a[i]);
    return v;}

print("Reduce.js\n");

a = [2, 3, 4];

//assert(a.reduce(plus, a, 0) ==  9);       // 1.8
  assert(  reduce(plus, a, 0) ==  9);

//assert(a.reduce(multiplies, a, 1) == 24); // 1.8
  assert(  reduce(multiplies, a, 1) == 24);

print("Done.\n");

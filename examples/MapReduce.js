// ------------
// MapReduce.js
// ------------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

print("MapReduce.js\n");

function square (x) {
    return x * x;}

function cube (x) {
    return x * x * x;}

function plus (x, y) {
    return x + y;}

function multiplies (x, y) {
    return x * y;}

function map (uf, a) {
    x = [];
    for (var i in a)
        x = x.concat(uf(a[i]));
    return x;}

function reduce (bf, a, v) {
    for (var i in a)
        v = bf(v, a[i]);
    return v;}

function map_reduce_1 (bf, uf, a, v) {
    return reduce(bf, map(uf, a), v);}

function map_reduce_2 (bf, uf, a, v) {
    for (var i in a)
        v = bf(v, uf(a[i]));
    return v;}

a = [2, 3, 4];

assert(map_reduce_1(plus,       square, a, 0) ==    29);
assert(map_reduce_1(plus,       cube,   a, 0) ==    99);
assert(map_reduce_1(multiplies, square, a, 1) ==   576);
assert(map_reduce_1(multiplies, cube,   a, 1) == 13824);

print("Done.\n");

// ------
// Map.js
// ------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

function square (x) {
    return x * x;}

function cube (x) {
    return x * x * x;}

function map (uf, a) {
    x = [];
    for (var i in a)
        x = x.concat(uf(a[i]));
    return x;}

print("Map.js\n");

a = [2, 3, 4];

x = a.map(square)        // 1.6
assert(x != [4, 9, 16]);
assert(x[0] ==  4);
assert(x[1] ==  9);
assert(x[2] == 16);

x = map(square, a)
assert(x != [4, 9, 16]);
assert(x[0] ==  4);
assert(x[1] ==  9);
assert(x[2] == 16);

x = a.map(cube)           // 1.6
assert(x != [8, 27, 64]);
assert(x[0] ==  8);
assert(x[1] == 27);
assert(x[2] == 64);

x = map(cube, a)
assert(x != [8, 27, 64]);
assert(x[0] ==  8);
assert(x[1] == 27);
assert(x[2] == 64);

print("Done.\n");

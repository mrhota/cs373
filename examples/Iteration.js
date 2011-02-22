// ------------
// Iteration.js
// ------------

function assert (b) {
    if (!b) {
        throw "Assertion Error"}}

print("Iteration.js\n");

var i = 0;
var s = 0;
while (i != 10) {
    s += i;
    ++i;}
assert(i == 10);
assert(s == 45);

var i = 0;
var s = 0;
do {
    s += i;
    ++i;}
while (i != 10);
assert(i == 10);
assert(s == 45);

var s = 0;
for (var i = 0; i != 10; ++i)
    s += i;
//assert i == 10;             // error: cannot find symbol
assert(s == 45);

var a = [2, 3, 4];
var s = 0;
for (var i = 0; i != 3; ++i)
    s += a[i];
assert(s == 9);

var a = [2, 3, 4];
var s = 0;
for (var i in a)
    s += a[i];
assert(s == 9);

print("Done.\n");

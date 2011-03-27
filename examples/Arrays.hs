-- ---------
-- Arrays.hs
-- ---------

{-
(>>)     :: IO a   -> IO b -> IO b  -- 'then' operator
assert   :: Bool   -> a    -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
-}

import Array
import Control.Exception (assert)

a :: Array Int String
a = listArray (1, 3) ["abc", "def", "ghi"]            -- dense

b :: Array Int String
b = array (1, 5) [(1, "abc"), (5, "ghi"), (3, "def")] -- sparse

main :: IO ()
main =
    putStrLn "Arrays.hs" >>

    assert (a == (array (1, 3) [(1, "abc"), (2, "def"), (3, "ghi")])) return () >>
--  assert (b == (array (1, 5) [(1, "abc"), (5, "ghi"), (3, "def")])) return () >> -- (Array.!): undefined array element

    assert ((bounds a) == (1, 3)) return () >>
    assert ((bounds b) == (1, 5)) return () >>

    assert ((indices a) == [1, 2, 3])       return () >>
    assert ((indices b) == [1, 2, 3, 4, 5]) return () >>

    assert ((elems a) == ["abc", "def", "ghi"]) return () >>
--  assert ((elems b) == ["abc", "def", "ghi"]) return () >> -- (Array.!): undefined array element

    assert ((assocs a) == [(1, "abc"), (2, "def"), (3, "ghi")]) return () >>
    assert ((assocs b) /= [(1, "abc"), (5, "ghi"), (3, "def")]) return () >>

    assert ((a ! 2) == "def") return () >>
--  assert ((a ! 4) == "jkl") return () >> -- Ix{Int}.index: Index (4) out of range ((1,3))
    assert ((b ! 3) == "def") return () >>
--  assert ((b ! 4) == "jkl") return () >> -- (Array.!): undefined array element

    assert ((a // [(2, "jkl")]) == (array (1, 3) [(1, "abc"), (2, "jkl"), (3, "ghi")])) return () >>
    assert (a ==                   (array (1, 3) [(1, "abc"), (2, "def"), (3, "ghi")])) return () >>

    putStrLn "Done."

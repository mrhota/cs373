-- ---------
-- Arrays.hs
-- ---------

{-
(>>)      :: IO a      -> IO b     -> IO b      -- 'then' operator
(!)       :: Array i e -> i        -> e
(//)      :: Array i e -> [(i, e)] -> Array i e
array     :: (i, i)    -> [(i, e)] -> Array i e
assert    :: Bool      -> a        -> a
assocs    :: Array i e             -> [(i, e)]
bounds    :: Array i e             -> (i, i)
elems     :: Array i e             -> [e]
indices   :: Array i e             -> [i]
listArray :: (i, i)    -> [e]      -> Array i e
putStrLn  :: String                -> IO ()
return    :: a                     -> IO a
-}

import Array
import Control.Exception (assert)

main :: IO ()
main =
    putStrLn "Arrays.hs" >>

    let a, b :: Array Int String
        a = listArray (1, 3) ["abc", "def", "ghi"]
        b = array     (1, 3) [(1, "abc"), (3, "ghi"), (2, "def")]

    in assert (a == b) return () >>

       assert ((bounds  a) == (1, 3))                               return () >>
       assert ((indices a) == [1, 2, 3])                            return () >>
       assert ((elems   a) == ["abc", "def", "ghi"])                return () >>
       assert ((assocs  a) == [(1, "abc"), (2, "def"), (3, "ghi")]) return () >>

       assert ((a ! 2) == "def") return () >>
--     assert ((a ! 4) == "jkl") return () >> -- Ix{Int}.index: Index (4) out of range ((1,3))

       assert ((a // [(2, "jkl")]) == (array (1, 3) [(1, "abc"), (2, "jkl"), (3, "ghi")])) return () >>

    putStrLn "Done."

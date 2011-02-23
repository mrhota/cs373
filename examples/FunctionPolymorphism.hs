-- -----------------------
-- FunctionPolymorphism.hs
-- -----------------------

-- parametric compile-time polymorphism

{-
(>>)     :: IO a   -> IO b -> IO b  -- 'then' operator
assert   :: Bool   -> a    -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
-}

{-
class Eq a where
    (==) :: a -> a -> Bool

instance Eq Int where
    (==) = ...

class (Eq a) => Ord a where
    (<) :: a -> a -> Bool

instance Ord Int where
    (<) = ...
-}

import Control.Exception (assert)

data A =
    A Int
    deriving (Eq, Ord)

myMax :: (Ord a) => a -> a -> a
myMax x y =
    if x < y then
        y
    else
        x

main :: IO ()
main =
    putStrLn "FunctionPolymorphism.hs"              >>
    assert ((A 3)               == (A 3)) return () >>
    assert ((myMax (A 2) (A 3)) == (A 3)) return () >>
    putStrLn "Done."

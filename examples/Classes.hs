-- ----------
-- Classes.hs
-- ----------

{-
(>>)     :: IO a   -> IO b -> IO b  -- 'then' operator
assert   :: Bool   -> a    -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
show     :: a              -> String
-}

import Control.Exception (assert)

data MyComplex =
    MyComplex {
        r :: Int,
        i :: Int}
    deriving (Eq, Show)

{-
instance Eq MyComplex where
    (MyComplex r1 i1) == (MyComplex r2 i2) = (r1 == r2) && (i1 == i2)

instance Show MyComplex where
    show (MyComplex r i) = "MyComplex {r = " ++ (show r) ++ ", i = " ++ (show i) ++ "}"
-}

conjugate :: MyComplex -> MyComplex
conjugate x = MyComplex (r x) (- (i x))

main :: IO ()
main =
    putStrLn "Classes.hs" >>

    let x, y, t :: MyComplex
        x = MyComplex 2 3
        y = MyComplex {r = 2, i = 3}
        t = conjugate y
    in assert (x        == (MyComplex 2 3))            return () >>
       assert ((r x) == 2)                             return () >>
       assert ((i x) == 3)                             return () >>
       assert ((show x) == "MyComplex {r = 2, i = 3}") return () >>
       assert (t        == (MyComplex 2 (-3)))         return () >>

    putStrLn "Done."

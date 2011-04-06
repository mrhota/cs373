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

data My_Complex
    = My_Complex {r :: Int, i :: Int}
    deriving (Eq, Show)

my_complex_1 :: My_Complex
my_complex_1 = My_Complex 0 0

my_complex_2 :: Int -> My_Complex
my_complex_2 rx = My_Complex rx 0

my_complex_3 :: Int -> Int -> My_Complex
my_complex_3 rx ix = My_Complex rx ix

{-
instance Eq My_Complex where
    (My_Complex r1 i1) == (My_Complex r2 i2) = (r1 == r2) && (i1 == i2)

instance Show My_Complex where
    show (My_Complex r1 i1) = "My_Complex {r = " ++ (show r1) ++ ", i = " ++ (show i1) ++ "}"
-}

conjugate :: My_Complex -> My_Complex
conjugate c = My_Complex (r c) (- (i c))

x :: My_Complex
x = my_complex_1

y :: My_Complex
y = my_complex_2 2

z :: My_Complex
z = my_complex_3 2 3

t :: My_Complex
t = conjugate z

main :: IO ()
main =
    putStrLn "Classes.hs" >>

    assert (x        == My_Complex 0 0)              return () >>
    assert ((show x) == "My_Complex {r = 0, i = 0}") return () >>

    assert (y        == My_Complex 2 0)              return () >>
    assert ((r y)    == 2)                           return () >>
    assert ((show y) == "My_Complex {r = 2, i = 0}") return () >>

    assert (z        == (My_Complex 2 3))            return () >>
    assert ((r z)    == 2)                           return () >>
    assert ((i z)    == 3)                           return () >>
    assert ((show z) == "My_Complex {r = 2, i = 3}") return () >>

    assert (t == (My_Complex 2 (-3))) return () >>

    putStrLn "Done."

-- -----------
-- Classes1.hs
-- -----------

{-
(>>)     :: IO a   -> IO b -> IO b  -- 'then' operator
assert   :: Bool   -> a    -> a
putStrLn :: String         -> IO ()
return   :: a              -> IO a
show     :: a              -> String
-}

import Control.Exception (assert)

data My_Complex
    = My_Complex1
    | My_Complex2 {r :: Int}
    | My_Complex3 {r :: Int, i :: Int}

instance Eq My_Complex where
    (My_Complex1)       == (My_Complex1)       = True
    (My_Complex1)       == (My_Complex2 r2)    = (r2 == 0)
    (My_Complex1)       == (My_Complex3 r2 i2) = (r2 == 0)  && (i2 == 0)
    (My_Complex2 r1)    == (My_Complex1)       = (r1 == 0)
    (My_Complex2 r1)    == (My_Complex2 r2)    = (r1 == r2)
    (My_Complex2 r1)    == (My_Complex3 r2 i2) = (r1 == r2) && (i2 == 0)
    (My_Complex3 r1 i1) == (My_Complex1)       = (r1 == 0)  && (i1 == 0)
    (My_Complex3 r1 i1) == (My_Complex2 r2)    = (r1 == r2) && (i1 == 0)
    (My_Complex3 r1 i1) == (My_Complex3 r2 i2) = (r1 == r2) && (i1 == i2)

instance Show My_Complex where
    show (My_Complex1)       = "My_Complex {r = " ++ "0"       ++ ", i = " ++ "0"       ++ "}"
    show (My_Complex2 r1)    = "My_Complex {r = " ++ (show r1) ++ ", i = " ++ "0"       ++ "}"
    show (My_Complex3 r1 i1) = "My_Complex {r = " ++ (show r1) ++ ", i = " ++ (show i1) ++ "}"

conjugate :: My_Complex -> My_Complex
conjugate c = My_Complex3 (r c) (- (i c))

x :: My_Complex
x = My_Complex1

y :: My_Complex
y = My_Complex2 2

z :: My_Complex
z = My_Complex3 2 3

t :: My_Complex
t = conjugate z

main :: IO ()
main =
    putStrLn "Classes1.hs" >>

    assert (x        == My_Complex3 0 0)             return () >>
    assert ((show x) == "My_Complex {r = 0, i = 0}") return () >>

    assert (y        == My_Complex3 2 0)             return () >>
    assert ((r y)    == 2)                           return () >>
    assert ((show y) == "My_Complex {r = 2, i = 0}") return () >>

    assert (z        == (My_Complex3 2 3))           return () >>
    assert ((r z)    == 2)                           return () >>
    assert ((i z)    == 3)                           return () >>
    assert ((show z) == "My_Complex {r = 2, i = 3}") return () >>

    assert (t == (My_Complex3 2 (-3))) return () >>

    putStrLn "Done."

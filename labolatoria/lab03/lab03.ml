let (><) l1 l2 = 
  let rec helper l1 l2 f = 
    match l1, l2 with
    | h1::t1, h2::t2 -> f h1 h2 :: helper t1 t2 f 
    | _ -> []
  in helper l1 l2;;
let list1 = [1;2;3;4;5;6;7];;
let list2 = [2;2;2;2;2;2;2];;
let result = (list1 >< list2) (fun a b -> a + b);;
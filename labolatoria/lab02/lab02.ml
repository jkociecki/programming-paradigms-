let cutOut list a b =
  let rec cut_helper a b list = 
    match list, a, b with 
    | _, 0, -1 -> []
    | h::t, 0, b -> h :: cut_helper 0 (b-1) t
    | _::t, _,  _ -> cut_helper (a-1) (b-1) t
    | [], _, _ -> []
  in
  match a < 0, a < b with
  | true, _ -> cut_helper 0 b list
  | _, false -> []
  | _ -> cut_helper a b list;;

let listsplit = [1;2;3;4;5;6;7;8;9];;
let listpslit1 = [1;2;3;4;5;6;7;8;9;10;11;12;13;14];;
let listsplit2 = [1;2];;
let listsplit3 = [1];;
let listsplit4 = [];;

let rec split3 list =
  match list with
  | x :: y :: z :: t -> let l1, l2, l3 = split3 t in x :: l1, y :: l2, z :: l3
  | _ -> [], [], [];;

split3 listsplit;;
split3 listpslit1;;
split3 listsplit2;;
split3 listsplit3;;
split3 listsplit4;;

let rec length list =
  match list with
  | h::t -> 1 + length t
  | [] -> 0;;
  
  let split3inorder list =
    let len3 = (length list) / 3 in 
    let rec s3o list n len depth =
      match list, depth = 3 with 
      | _, true -> [], [], []
      | h::t, _ when n = len -> let l1, l2, l3 = s3o t 1 len (depth+1) in h::l3, l1, l2
      | h::t, _ -> let l1, l2, l3 = s3o t (n+1) len depth in h::l1, l2, l3
      | _ -> [], [], []
                                                             
    in if len3 = 0 then [],[],[] else s3o list 1 len3 0;;

let split3tail list = 
  let rec s3t_aux acc list = 
    match list, acc with
    | x :: y :: z :: t, (l1, l2, l3) -> s3t_aux(x::l1, y::l2, z::l3) t
    | _, _ -> acc in s3t_aux ([], [], []) list;;
split3tail listsplit;;
split3tail listpslit1;; 
split3tail listsplit2;;
split3tail listsplit3;;
split3tail listsplit4;;




split3inorder listsplit;;
split3inorder listpslit1;;
split3inorder listsplit2;;
split3inorder listsplit3;;
split3inorder listsplit4;;


let split3inorderT list = 
  let rec reverse list acc = 
    match list with
    | h::t -> reverse t (h::acc)
    | _ -> acc in

  let len3 = (length list) / 3 in 

  let rec s3t list n len depth l1 l2 l3 = 
    match list, depth = 3, (l1, l2, l3) with
    | _, true, _ -> (l1, l2, l3)
    | h::t, _ ,(l1, l2, l3) when n = len -> s3t t 1 len (depth+1) (h::l2) l3 l1
    | h::t, _, (l1, l2, l3) -> s3t t (n+1) len depth l1 (h::l2) l3
    | _ -> ([], [], []) in

  let (l1, l2, l3) = s3t list 1 len3 0 [] [] [] in (reverse l2 [], reverse l3 [], reverse l1 []);;
split3inorderT listsplit;;
split3inorderT listpslit1;;
split3inorderT listsplit2;;
split3inorderT listsplit3;;
split3inorderT listsplit4;;


  
 

                                                                       
                 
;-------Problem 1-------
(defn sequence-to-power [x n]
  (if (= n 0)
    '()
    (concat x (sequence-to-power x (- n 1))))) 

;-------Problem 2--------
(defn in-L? [l]
  (if (empty? l)
    true
    (if (= (first l) 'a)
      (in-L? (rest l))
      false))) 

;-------Problem 3--------
(def add-to-end (fn [l x] 
                  (if (empty? l)
                    (cons x l)
                    (cons(first l) 
                      (add-to-end (rest l) x)))))

(defn generate-an-bn [k]
  (if (= 0 k)
    '()
    (add-to-end(cons 'a (generate-an-bn(- k 1))) 'b)))



;-------Problem 4--------
(def reverse (fn [l]
               (if (empty? l)
                 '()
                 (cons (last l) (reverse(drop-last l))))))

(defn remove-last-element [l] 
  (reverse(rest(reverse l))))

;-------Problem 5--------
(defn recognize-an-bn [str]
  (if (even? (count str))
    (if(=(generate-an-bn (/ (count str) 2)) str)
      true)
    false))

;-------Problem 6--------
(defn concat-L-A [L A]
  (if (empty? L)
    '()
    (concat
      (map (fn [x] (concat (first L) x))
        A)
      (concat-L-A (rest L) A))))

;-------Problem 7--------
;If you let A = {a,aa,aaa} and B = {aaaa, aaaaa, aaaaaa}, then:
;CONCAT(A,B) = {aaaaa, aaaaaa, aaaaaaa, aaaaaa, aaaaaaa, aaaaaaaa, 
		aaaaaaa, aaaaaaaa, aaaaaaaaa}
;CONCAT(B,A) = {aaaaa, aaaaaa, aaaaaaa, aaaaaa, aaaaaaa, aaaaaaaa,
		aaaaaaa, aaaaaaaa, aaaaaaaaa}

; So CONCAT(A,B) == CONCAT(B,A)

;-------Problem 8--------
;If you let A = {a,aa,aaa} and B = {b,bb,bbb}, then: 
;CONCAT(A,B) = {ab, abb, abbb, aab, aabb, aabbb, aaab, aaabb, aaabbb}
;CONCAT(B,A) = {ba, baa, baaa, bba, bbaa, bbaaa, bbba, bbbaa, bbbaaa}

; So CONCAT(A,B) != CONCAT(B,A)

;-------Problem 9--------
L = {a, aa, aaa, aaa, aaaa, ...}



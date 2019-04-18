;;------Problem 1-------

defn abs [num] (Math/sqrt (* num num))

;;------Problem 2-------

(comment 

The code:

	(defn take-square (* x x)) 

is attempting to define a function without any parameters.
 
To fix this, the program can be written as:
	
	(defn take-square [x] (* x x))

where [x] represents the parameter to be acted on by the function.


The code: 

	(defn sum-of-squares [(take-square x) (take-square y)]
	  (+ (take-square x) (take-square y)))

is attempting to invoke functions on parameters before the parameters have been explicitly defined. 

To fix this, the program can be written as:

	(defn sum-of-squares [x y]
	  (+ (take-square x) (take-square y)))

so that Clojure does not attempt to perform a function on the parameters before they are defined in the function.

)

;;------Problem 3-------

(def exp-13-1 (+ 12 1))
(def exp-13-2 (+ 10 3))
(def exp-13-3 (+ 9 4))
(def exp-13-4 (+ 8 5))
exp-13-1
exp-13-2
exp-13-3
exp-13-4

;;------Problem 4-------

(defn third [l] (first(rest(rest l))))

;;------Problem 5-------

(defn compose [f g] (fn [x] (f (g x))))

;;------Problem 6-------

(defn first-two [l] (cons 
                      (first l)
                      (list(first(rest l)))))

;;------Problem 7-------

(defn remove-second [l] (cons
                          (first l) 
                          (rest(rest l))))

;;------Problem 8-------

(def add-to-end (fn [l x] 
                  (if (empty? l)
                    (cons x l)
                    (cons(first l) 
                      (add-to-end (rest l) x)))))

;;------Problem 9-------

(def reverse (fn [l]
               (if (empty? l)
                 '()
                 (cons (last l) (reverse(drop-last l))))))

;;------Problem 10-------

(def count-to-1 (fn [n]
                  (if (= n 1)
                    (cons n '())
                    (cons n (count-to-1 (- n 1))))))

;;------Problem 11-------

(def count-to-n (fn [n]
                  (reverse(count-to-1 n))))

;;------Problem 12-------

(def get-max (fn [l]
               (if (= (count l) 1)
                 (first l)
                 (if (> (first l) (last l))
                   (get-max (drop-last l))
                   (get-max (rest l))))))

;;------Problem 13-------
(def greater-than-five? (fn [l]
                          (if (empty? l)
                            '()
                            (cons
                              (> (first l) 5) 
                              (greater-than-five? (rest l))))))


;;------Problem 14-------
(def concat-three (fn [a b c]
                    (if (empty? a)
                      (if (empty? b)
                        (if (empty? c)
                          '()
                          (cons(first c) (concat-three a b (rest c))))
                        (cons(first b) (concat-three a (rest b) c)))
                      (cons(first a) (concat-three (rest a) b c)))))


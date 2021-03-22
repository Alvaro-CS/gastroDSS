;; all the answers must be in capital letters and belong to the options shown in each question

;; TEMPLATE DEFINING A PATIENT 
;; contains variables entered by the user and control variables

(deftemplate Patient
	(slot name)
	(slot age)	
	(slot per_age_computed (default FALSE))
	(slot alcohol_intake)
	(slot per_alcohol_intake_computed (default FALSE))
	
	(slot total_per (default 1))
	(slot decision)
	(slot decision_taken (default FALSE))
	
	(slot more_patients))
	
;; RULES TO COMPUTE THE ASSOCIATED WEIGHTS FOR EACH PARAMETER 
;; the rules multiply total 
;; to avoid firing the same rule over the same data we use control variables per_*_computed (FALSE if not fired, TRUE if fired over that patient
;; total_per holds the product of the weight all along the procedure
	

(defrule Age1
	?p <- (Patient (age ?t)  (per_age_computed FALSE) (total_per ?total))
	(test (numberp ?t))
	(test (<= ?t 20))
	=>
	(printout t "Percentage given by age" crlf)
	(modify ?p (total_per (* ?total 0.06)) (per_age_computed TRUE)))	

(defrule Age2
	?p <- (Patient (age ?t)  (per_age_computed FALSE) (total_per ?total))
	(test (numberp ?t))
	(test (and (> ?t 20) (<= ?t 60)))
	=>
	(printout t "Percentage given by age" crlf)
	(modify ?p (total_per (* ?total 0.44)) (per_age_computed TRUE)))	
	
(defrule Age3
	?p <- (Patient (age ?t)  (per_age_computed FALSE) (total_per ?total))
	(test (numberp ?t))
	(test (> ?t 60))
	=>
	(printout t "Percentage given by age" crlf)
	(modify ?p (total_per (* ?total 3.84)) (per_age_computed TRUE)))
	

	
(defrule Alcohol1
	?p <- (Patient (alcohol_intake NO)  (per_alcohol_intake_computed FALSE) (total_per ?total))
	=>
	(modify ?p (total_per (* ?total 1.0)) (per_alcohol_intake_computed TRUE)))

(defrule Alcohol2
	?p <- (Patient (alcohol_intake YES)  (per_alcohol_intake_computed FALSE) (total_per ?total))
	=>
	(printout t "Hello" crlf)
	(modify ?p (total_per (* ?total 1.5)) (per_alcohol_intake_computed TRUE)))



;; FINAL COMPUTATION 
;; checks the value hold in total_per with 3 intervals to give a final decision among the 3 options/alternatives 

(defrule Total1 
	(declare (salience -500))
	?p <- (Patient (name ?name) (total_per ?total) (decision nil) (decision_taken FALSE))
	(test (numberp ?total))
	(test (<= ?total 5))
	=>
	(modify ?p (decision A) (decision_taken TRUE))
	(printout t "Decision A for: " ?name crlf)
	(printout t "Total percentage: " ?total crlf))


(defrule Total2
	(declare (salience -500))
	?p <- (Patient (name ?name) (total_per ?total) (decision nil) (decision_taken FALSE))
	(test (numberp ?total))
	(test (and (> ?total 5) (<= ?total 20)))
	=>
	(modify ?p (decision B) (decision_taken TRUE))
	(printout t "Decision B for: " ?name crlf)
	(printout t "Total percentage: " ?total crlf))
		
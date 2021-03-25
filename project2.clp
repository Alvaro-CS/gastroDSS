;; TEMPLATES
(deftemplate disease
	(slot name)
	(slot total)
	(slot score (default 0)))

(deftemplate symptom
	(slot name)
	(slot activated (default FALSE))
	(slot present (default NO))
	(slot asked (default NO)))

;;DISEASE FACTS
(deffacts diseases "Diseases"
	(disease (name gastroenteritis) (total 47))
	(disease (name pancreatitis) (total 46) (score -15))
	(disease (name achalasia) (total 45) (score -20))
	(disease (name celiac-disease) (total 56) (score -10))
	(disease (name crohn-disease) (total 61) (score -15))
	(disease (name peptic-ulcer) (total 73) (score -15))
	(disease (name ulcerative-colitis) (total 43) (score -15))
	(disease (name hepatic-cirrhosis) (total 64) (score -10))
	(disease (name erge) (total 75) (score -5))
	(disease (name cholelithiasis) (total 32))
	(disease (name stomach-cancer) (total 40) (score -20))
	(disease (name gastritis) (total 42))
)

;;SYMPTOM FACTS
;;(deffacts symptoms "Symptoms"
;;	(symptom (name abdominal-pain))
;;	(symptom (name dysphagia))
;;	(symptom (name reflux))
;;	(symptom (name cough))
;;	(symptom (name thoracic-pain))
;;	(symptom (name heartburn))
;;	(symptom (name weight-loss))
;;	(symptom (name fever))
;;	(symptom (name rapid-pulsations))
;;	(symptom (name nausea))
;;	(symptom (name vomit))
;;	(symptom (name headache))
;;	(symptom (name diarrhea))
;;	(symptom (name upper-right-vague-pain))
;;	(symptom (name colics))
;;	(symptom (name impotence))
;;	(symptom (name infertility))
;;	(symptom (name amenorrhea))
;;	(symptom (name ictericia))
;;	(symptom (name melena))
;;	(symptom (name upper-abdominal-pain))
;;	(symptom (name muscular-pain))
;;	(symptom (name fatigue))
;;	(symptom (name anorexia))
;;	(symptom (name rectal-tenesmus))
;;	(symptom (name anemia))
;;	(symptom (name constipation))
;;	(symptom (name gas))
;;	(symptom (name regurgitation))
;;	(symptom (name dermatitis-herpetiformis))
;;	(symptom (name aphthous-stomatiti))
;;)


;; ASK QUESTION
(deffunction ask-question (?question $?allowed-values) 
	(printout t ?question) 
	(bind ?answer (read)) 
	(if (lexemep ?answer)
		then (bind ?answer (upcase ?answer))) 
	(while (not (member$ ?answer ?allowed-values)) do 
	(printout t ?question) 
	(bind ?answer (read)) 
	(if (lexemep ?answer) 
		then (bind ?answer (upcase ?answer)))) (upcase ?answer)) 


;;ASK SYMPTOMS

;;DYSPHAGIA 
(defrule get-dysphagia
	(declare (salience 593))
	?symptom<-(symptom (name dysphagia) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present dysphagia? (YES/NO): " YES NO)) (asked YES) ))	

;;REFLUX
(defrule get-reflux
	(declare (salience 594))
	?symptom<-(symptom (name reflux) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present reflux? (YES/NO): " YES NO)) (asked YES) ))	

;;COUGH
(defrule get-cough
	(declare (salience 592))
	?symptom<-(symptom (name cough) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present cough? (YES/NO): "  YES NO)) (asked YES) ))	

;;THORACIC-PAIN
(defrule get-thoracic-pain
	(declare (salience 578))
	?symptom<-(symptom (name thoracic-pain) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present thoracic pain? (YES/NO): "  YES NO)) (asked YES) ))	

;;HEARTBURN 
(defrule get-heartburn
	(declare (salience 591))
	?symptom<-(symptom (name heartburn) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present heartburn? (YES/NO): "  YES NO)) (asked YES) ))	

;;WEIGHT-LOSS 
(defrule get-weight-loss
	(declare (salience 589))
	?symptom<-(symptom (name weight-loss) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present weight loss? (YES/NO): "  YES NO)) (asked YES) ))	

;;FEVER 
(defrule get-fever
	(declare (salience 581))
	?symptom<-(symptom (name fever) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present fever? (YES/NO): "  YES NO)) (asked YES) ))	

;;RAPID-PULSATIONS 
	(defrule get-rapid-pulsations
	(declare (salience 576))
	?symptom<-(symptom (name rapid-pulsations) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present rapid pulsations? (YES/NO): " YES NO)) (asked YES) ))

;;NAUSEA 
(defrule get-nausea
	(declare (salience 597))
	?symptom<-(symptom (name nausea) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present nausea? (YES/NO): "  YES NO)) (asked YES) ))	

;;VOMIT
(defrule get-vomit
	(declare (salience 596))
	?symptom<-(symptom (name vomit) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present vomit? (YES/NO): "  YES NO)) (asked YES) ))	

;;DIARRHEA
(defrule get-diarrhea
	(declare (salience 583))
	?symptom<-(symptom (name diarrhea) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present diarrhea? (YES/NO): "  YES NO)) (asked YES) ))	

;;UPPER-RIGHT-VAGUE-PAIN 
(defrule get-upper-right-vague-pain
	(declare (salience 598))
	?symptom<-(symptom (name upper-right-vague-pain) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present upper right vague pain? (YES/NO): "  YES NO)) (asked YES) ))	

;;COLICS 
(defrule get-colics
	(declare (salience 585))
	?symptom<-(symptom (name colics) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present colics? (YES/NO): "  YES NO)) (asked YES) ))	

;;IMPOTENCE 
(defrule get-impotence
	(declare (salience 572))
	?symptom<-(symptom (name impotence) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present impotence? (YES/NO): "  YES NO)) (asked YES) ))	

;;INFERTILITY
(defrule get-infertility
	(declare (salience 571))
	?symptom<-(symptom (name infertility) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present infertility? (YES/NO): "  YES NO)) (asked YES) ))	

;;AMENORRHEA
(defrule get-amenorrhea
	(declare (salience 570))
	?symptom<-(symptom (name amenorrhea) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present amenorrhea (no period)? (YES/NO): " YES NO)) (asked YES) ))	

;;ICTERICIA
(defrule get-ictericia
	(declare (salience 577))
	?symptom<-(symptom (name ictericia) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present ictericia? (YES/NO): " YES NO)) (asked YES) ))	

;;MELENA
(defrule get-melena
	(declare (salience 582))
	?symptom<-(symptom (name melena) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present melena? (YES/NO): " YES NO)) (asked YES) ))	

;;ABDOMINAL PAIN
(defrule get-abdominal-pain
	(declare (salience 600))
	?symptom<-(symptom (name abdominal-pain) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present abdominal pain? (YES/NO): " YES NO)) (asked YES) ))	

;;UPPER-ABDOMINAL-PAIN
(defrule get-upper-abdominal-pain
	(declare (salience 599))
	?symptom<-(symptom (name upper-abdominal-pain) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present upper abdominal pain? (YES/NO): " YES NO)) (asked YES) ))	

;;HEADACHE
(defrule get-headache
	(declare (salience 580))
	?symptom<-(symptom (name headache) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present headache? (YES/NO): " YES NO)) (asked YES) ))	

;;MUSCULAR-PAIN 
(defrule get-muscular-pain
	(declare (salience 579))
	?symptom<-(symptom (name muscular-pain) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present muscular pain? (YES/NO): " YES NO)) (asked YES) ))	

;;FATIGUE 
(defrule get-fatigue
	(declare (salience 588))
	?symptom<-(symptom (name fatigue) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present fatigue? (YES/NO): " YES NO)) (asked YES) ))	

;;ANOREXIA
(defrule get-anorexia
	(declare (salience 590))
	?symptom<-(symptom (name anorexia) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present anorexia (lack of appetite)? (YES/NO): " YES NO)) (asked YES) ))	

;;RECTAL-TENESMUS
(defrule get-rectal-tenesmus
	(declare (salience 584))
	?symptom<-(symptom (name rectal-tenesmus) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present rectal tenesmus (incomplete evacuation feeling)? (YES/NO): " YES NO)) (asked YES) ))	

;;ANEMIA 
(defrule get-anemia
	(declare (salience 575))
	?symptom<-(symptom (name anemia) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present anemia? (YES/NO): " YES NO)) (asked YES) ))	

;;CONSTIPATION
(defrule get-constipation
	(declare (salience 587))
	?symptom<-(symptom (name constipation) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present constipation? (YES/NO): " YES NO)) (asked YES) ))	

;;GAS
(defrule get-gas
	(declare (salience 586))
	?symptom<-(symptom (name gas) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present gas? (YES/NO): " YES NO)) (asked YES) ))	

;;REGURGITATION
(defrule get-regurgitation
	(declare (salience 595))
	?symptom<-(symptom (name regurgitation) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present regurgitation? (YES/NO): " YES NO)) (asked YES) ))	

;;DERMATITIS-HERPETIFORMIS
(defrule get-dermatitis-herpetiformis
	(declare (salience 574))
	?symptom<-(symptom (name dermatitis-herpetiformis) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present dermatitis herpetiformis? (YES/NO): " YES NO)) (asked YES) ))	

;;APHTHOUS-STOMATITI
(defrule get-aphthous-stomatiti
	(declare (salience 573))
	?symptom<-(symptom (name aphthous-stomatiti) (asked NO))
	=>
	(modify ?symptom (present (ask-question "Does the patient present aphthous stomatiti (mouth sores)? (YES/NO): " YES NO)) (asked YES) ))	


;;ADD SYMPTOMS TO DISEASES

;;ABDOMINAL PAIN
(defrule abdominal-pain
  ?gastroenteritis <-(disease (name gastroenteritis) (score ?score1))
  ?pancreatitis <-(disease (name pancreatitis) (score ?score2))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score3))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score4))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score5))
  ?gastritis <-(disease (name gastritis) (score ?score6))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score7))
  ?erge <-(disease (name erge) (score ?score8))
  ?cholelithiasis <-(disease (name cholelithiasis) (score ?score9))
  ?stomach-cancer <-(disease (name stomach-cancer) (score ?score10))
  ?crohn-disease <-(disease (name crohn-disease) (score ?score11))
  ?symptom<-(symptom (name abdominal-pain) (activated FALSE) (present YES))
  =>
  (modify ?gastroenteritis (score (+ ?score1  9)))
  (modify ?pancreatitis (score (+ ?score2  8)))
  (modify ?celiac-disease (score (+ ?score3  5)))
  (modify ?ulcerative-colitis (score (+ ?score4 4)))
  (modify ?hepatic-cirrhosis (score (+ ?score5  6)))
  (modify ?gastritis (score (+ ?score6  5)))
  (modify ?peptic-ulcer (score (+ ?score7  8)))
  (modify ?erge (score (+ ?score8  4)))
  (modify ?cholelithiasis (score (+ ?score9  6)))
  (modify ?stomach-cancer (score (+ ?score10  4)))
  (modify ?crohn-disease (score (+ ?score11  10)))
  (modify ?symptom (activated TRUE)) 
)

;;DYSPHAGIA
(defrule dysphagia
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?erge <-(disease (name erge) (score ?score2))
  ?stomach-cancer <-(disease (name stomach-cancer ) (score ?score3))
  ?symptom<-(symptom (name dysphagia) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 10)))
  (modify ?erge (score (+ ?score2 7)))
  (modify ?stomach-cancer (score (+ ?score3 4)))
  (modify ?symptom (activated TRUE)) 
)

;;REFLUX 
(defrule reflux
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?erge <-(disease (name erge) (score ?score2))
  ?symptom<-(symptom (name reflux) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 7)))
  (modify ?erge (score (+ ?score2 9)))
  (modify ?symptom (activated TRUE)) 
)

;;COUGH
(defrule cough
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?erge <-(disease (name erge) (score ?score2))
  ?symptom<-(symptom (name cough) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 8)))
  (modify ?erge (score (+ ?score2 8)))
  (modify ?symptom (activated TRUE)) 
)

;;THORACIC-PAIN
(defrule thoracic-pain
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?erge <-(disease (name erge) (score ?score2))
  ?peptic-ulcer <-(disease (name peptic-ulcer ) (score ?score3))
  ?symptom<-(symptom (name thoracic-pain) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 6)))
  (modify ?erge (score (+ ?score2 7)))
  (modify ?peptic-ulcer (score (+ ?score3 9)))
  (modify ?symptom (activated TRUE)) 
)

;;HEARTBURN 
(defrule heartburn
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?erge <-(disease (name erge) (score ?score2))
  ?stomach-cancer <-(disease (name stomach-cancer ) (score ?score3))
  ?peptic-ulcer <-(disease (name peptic-ulcer ) (score ?score4))
  ?symptom<-(symptom (name heartburn) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 6)))
  (modify ?erge (score (+ ?score2 8)))
  (modify ?stomach-cancer (score (+ ?score3 3)))
  (modify ?peptic-ulcer (score (+ ?score4 8)))
  (modify ?symptom (activated TRUE)) 
)

;;WEIGHT-LOSS
(defrule weight-loss
  ?achalasia <-(disease (name achalasia) (score ?score1))
  ?crohn-disease <-(disease (name crohn-disease ) (score ?score2))
  ?stomach-cancer <-(disease (name stomach-cancer ) (score ?score3))
  ?peptic-ulcer <-(disease (name peptic-ulcer ) (score ?score4))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis ) (score ?score5))
  ?symptom<-(symptom (name weight-loss) (activated FALSE) (present YES))
  =>
  (modify ?achalasia (score (+ ?score1 8)))
  (modify ?crohn-disease (score (+ ?score2 7)))
  (modify ?stomach-cancer (score (+ ?score3 8)))
  (modify ?peptic-ulcer (score (+ ?score4 6)))
  (modify ?ulcerative-colitis (score (+ ?score5 7)))
  (modify ?symptom (activated TRUE)) 
)

;;FEVER 
(defrule fever
  ?pancreatitis <-(disease (name pancreatitis) (score ?score1))
  ?crohn-disease <-(disease (name crohn-disease ) (score ?score2))
  ?gastroenteritis <-(disease (name gastroenteritis ) (score ?score3))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis ) (score ?score4))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis ) (score ?score5))
  ?symptom<-(symptom (name fever) (activated FALSE) (present YES))
  =>
  (modify ?pancreatitis (score (+ ?score1 8)))
  (modify ?crohn-disease (score (+ ?score2 7)))
  (modify ?gastroenteritis (score (+ ?score3 9)))
  (modify ?hepatic-cirrhosis (score (+ ?score4 6)))
  (modify ?ulcerative-colitis (score (+ ?score5 7)))
  (modify ?symptom (activated TRUE)) 
)

;;RAPID-PULSATIONS
(defrule rapid-pulsations
  ?pancreatitis <-(disease (name pancreatitis) (score ?score1))
  ?symptom<-(symptom (name rapid-pulsations) (activated FALSE) (present YES))
  =>
  (modify ?pancreatitis (score (+ ?score1 7)))
  (modify ?symptom (activated TRUE)) 
)

;;NAUSEA
(defrule nausea
  ?pancreatitis <-(disease (name pancreatitis) (score ?score1))
  ?celiac-disease <-(disease (name celiac-disease ) (score ?score2))
  ?gastroenteritis <-(disease (name gastroenteritis ) (score ?score3))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis ) (score ?score4))
  ?gastritis <-(disease (name gastritis ) (score ?score5))
  ?peptic-ulcer <-(disease (name peptic-ulcer ) (score ?score6))
  ?cholelithiasis <-(disease (name cholelithiasis ) (score ?score7))
  ?erge <-(disease (name erge ) (score ?score8))
  ?stomach-cancer <-(disease (name stomach-cancer ) (score ?score9))
  ?symptom<-(symptom (name nausea) (activated FALSE) (present YES))
  =>
  (modify ?pancreatitis (score (+ ?score1 6)))
  (modify ?celiac-disease (score (+ ?score2 7)))
  (modify ?gastroenteritis (score (+ ?score3 8)))

  (modify ?hepatic-cirrhosis (score (+ ?score4 6)))
  (modify ?gastritis (score (+ ?score5 9)))
  (modify ?peptic-ulcer (score (+ ?score6 8)))
  (modify ?cholelithiasis(score (+ ?score7 7)))
  (modify ?erge(score (+ ?score8 8)))
  (modify ?stomach-cancer(score (+ ?score9 6)))
  (modify ?symptom (activated TRUE)) 
)

;;VOMIT 
(defrule vomit
  ?pancreatitis <-(disease (name pancreatitis) (score ?score1))
  ?celiac-disease <-(disease (name celiac-disease ) (score ?score2))
  ?gastroenteritis <-(disease (name gastroenteritis ) (score ?score3))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis ) (score ?score4))
  ?gastritis <-(disease (name gastritis ) (score ?score5))
  ?peptic-ulcer <-(disease (name peptic-ulcer ) (score ?score6))
  ?cholelithiasis <-(disease (name cholelithiasis ) (score ?score7))
  ?erge <-(disease (name erge ) (score ?score8))
  ?stomach-cancer <-(disease (name stomach-cancer ) (score ?score9))
  ?symptom<-(symptom (name vomit) (activated FALSE) (present YES))
  =>
  (modify ?pancreatitis (score (+ ?score1 7)))
  (modify ?celiac-disease (score (+ ?score2 8)))
  (modify ?gastroenteritis (score (+ ?score3 10)))
  (modify ?hepatic-cirrhosis (score (+ ?score4 6)))
  (modify ?gastritis (score (+ ?score5 9)))
  (modify ?peptic-ulcer (score (+ ?score6 9)))
  (modify ?cholelithiasis(score (+ ?score7 7)))
  (modify ?erge(score (+ ?score8 8)))
  (modify ?stomach-cancer(score (+ ?score9 7)))
  (modify ?symptom (activated TRUE)) 
)

;;DIARRHEA 
(defrule diarrhea
  ?crohn-disease <-(disease (name crohn-disease) (score ?score1))
  ?celiac-disease <-(disease (name celiac-disease ) (score ?score2))
  ?gastroenteritis <-(disease (name gastroenteritis ) (score ?score3))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis ) (score ?score4))
  ?symptom<-(symptom (name diarrhea) (activated FALSE) (present YES))
  =>
  (modify ?crohn-disease (score (+ ?score1 10)))
  (modify ?celiac-disease (score (+ ?score2 5)))
  (modify ?gastroenteritis (score (+ ?score3 5)))
  (modify ?hepatic-cirrhosis (score (+ ?score4 5)))
  (modify ?symptom (activated TRUE)) 
)

;;UPPER-RIGHT-VAGUE-PAIN (cirrosis)
(defrule upper-right-vague-pain
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis ) (score ?score1))
  ?symptom<-(symptom (name upper-right-vague-pain) (activated FALSE) (present YES))
  =>
  (modify ?hepatic-cirrhosis (score (+ ?score1 5)))
  (modify ?symptom (activated TRUE)) 
)

;;COLICS
(defrule colics
  ?crohn-disease <-(disease (name crohn-disease ) (score ?score1))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score2))
   ?symptom<-(symptom (name colics) (activated FALSE) (present YES))
  =>
  (modify ?crohn-disease  (score (+ ?score1 8 )))
  (modify ?ulcerative-colitis (score (+ ?score2 1 )))
  (modify ?symptom (activated TRUE)) 
)

;;IMPOTENCE
(defrule impotence
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score1))
   ?symptom<-(symptom (name impotence) (activated FALSE) (present YES))
  =>
  (modify ?hepatic-cirrhosis  (score (+ ?score1 2)))
  (modify ?symptom (activated TRUE))
)

;;INFERTILITY
(defrule infertility
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score1))
   ?symptom<-(symptom (name infertility) (activated FALSE) (present YES))
  =>
  (modify ?hepatic-cirrhosis  (score (+ ?score1 2)))
    (modify ?symptom (activated TRUE)) 
)

;;AMENORRHEA
(defrule amenorrhea
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score1))
   ?symptom<-(symptom (name amenorrhea) (activated FALSE) (present YES))
  =>
  (modify ?hepatic-cirrhosis  (score (+ ?score1 2)))
  (modify ?symptom (activated TRUE)) 
)

;;ICTERICIA
(defrule ictericia
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score1))
  ?cholelithiasis <-(disease (name cholelithiasis) (score ?score2))
  ?symptom<-(symptom (name ictericia) (activated FALSE) (present YES))
  =>
  (modify ?hepatic-cirrhosis  (score (+ ?score1 8)))
  (modify ?cholelithiasis  (score (+ ?score2 5)))
   (modify ?symptom (activated TRUE)) 
)

;;MELENA
(defrule melena
  ?crohn-disease <-(disease (name crohn-disease) (score ?score1))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score2))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score3))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score4))
  ?gastritis <-(disease (name gastritis) (score ?score5))
  ?symptom<-(symptom (name melena) (activated FALSE) (present YES))
  =>
  (modify ?crohn-disease (score (+ ?score1 5)))
  (modify ?ulcerative-colitis (score (+ ?score2 10)))
  (modify ?peptic-ulcer (score (+ ?score3 8)))
  (modify ?celiac-disease (score (+ ?score4 1)))
  (modify ?gastritis (score (+ ?score5 1)))
  (modify ?symptom (activated TRUE)) 
)

;;UPPER-ABDOMINAL PAIN
(defrule upper-abdominal-pain
  ?gastritis <-(disease (name gastritis) (score ?score1))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score2))
  ?cholelithiasis <-(disease (name cholelithiasis) (score ?score3))
  ?crohn-disease <-(disease (name crohn-disease) (score ?score4))
  ?erge <-(disease (name erge) (score ?score5))
  ?stomach-cancer <-(disease (name stomach-cancer) (score ?score6))
  ?pancreatitis <-(disease (name pancreatitis) (score ?score7))
  ?symptom<-(symptom (name upper-abdominal-pain) (activated FALSE) (present YES))
  =>
  (modify ?gastritis (score (+ ?score1 8)))
  (modify ?peptic-ulcer (score (+ ?score2 8)))
  (modify ?cholelithiasis (score (+ ?score3 7)))
  (modify ?crohn-disease (score (+ ?score4 8)))
  (modify ?erge (score (+ ?score5 7)))
  (modify ?stomach-cancer (score (+ ?score6  4)))
  (modify ?pancreatitis (score (+ ?score7 7)))
  (modify ?symptom (activated TRUE)) 
)

;;HEADACHE
(defrule headache
  ?gastroenteritis <-(disease (name gastroenteritis) (score ?score1))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score2))   
  ?pancreatitis <-(disease (name pancreatitis) (score ?score3))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score4))   
  ?symptom<-(symptom (name headache) (activated FALSE) (present YES))
  =>
  (modify ?gastroenteritis (score (+ ?score1 2)))
  (modify ?celiac-disease (score (+ ?score2 4)))
  (modify ?pancreatitis (score (+ ?score3 3)))
  (modify ?peptic-ulcer (score (+ ?score4 2)))  
  (modify ?symptom (activated TRUE)) 
)

;;MUSCULAR-PAIN
(defrule muscular-pain
  ?gastroenteritis <-(disease (name gastroenteritis) (score ?score1))
  ?gastritis <-(disease (name gastritis) (score ?score2))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score3))
   ?symptom<-(symptom (name muscular-pain) (activated FALSE) (present YES))
  =>
  (modify ?gastroenteritis (score (+ ?score1 2)))
  (modify ?gastritis (score (+ ?score2 2)))
  (modify ?celiac-disease (score (+ ?score3 2)))
   (modify ?symptom (activated TRUE)) 
)

;;FATIGUE
(defrule fatigue
  ?crohn-disease <-(disease (name crohn-disease) (score ?score1))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score2))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score3))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score4))
  ?gastroenteritis <-(disease (name gastroenteritis) (score ?score5))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score6))
  ?symptom<-(symptom (name fatigue) (activated FALSE) (present YES))
  =>
  (modify ?crohn-disease (score (+ ?score1 1)))
  (modify ?ulcerative-colitis (score (+ ?score2  1)))
  (modify ?hepatic-cirrhosis (score (+ ?score3  8)))
  (modify ?peptic-ulcer (score (+ ?score4  2)))
  (modify ?gastroenteritis (score (+ ?score5 2)))
  (modify ?celiac-disease (score (+ ?score6  5)))
  (modify ?symptom (activated TRUE)) 
)

;;ANOREXIA 
(defrule anorexia
  ?crohn-disease <-(disease (name crohn-disease) (score ?score1))
  ?hepatic-cirrhosis <-(disease (name hepatic-cirrhosis) (score ?score2))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score3))
  ?gastritis <-(disease (name gastritis) (score ?score4))
  ?peptic-ulcer <-(disease (name peptic-ulcer) (score ?score5))
  ?stomach-cancer <-(disease (name stomach-cancer) (score ?score6))
  ?symptom<-(symptom (name anorexia) (activated FALSE) (present YES))
   =>
  (modify ?crohn-disease (score (+ ?score1  4)))
  (modify ?hepatic-cirrhosis (score (+ ?score2  8)))
  (modify ?ulcerative-colitis (score (+ ?score3  4)))
  (modify ?gastritis (score (+ ?score4  8)))
  (modify ?peptic-ulcer (score (+ ?score5 5)))
  (modify ?stomach-cancer (score (+ ?score6 4)))
  (modify ?symptom (activated TRUE)) 
)

;;RECTAL-TENESMUS
(defrule rectal-tenesmus
  ?crohn-disease <-(disease (name crohn-disease) (score ?score1))
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score2))
  ?symptom<-(symptom (name rectal-tenesmus) (activated FALSE) (present YES))
  =>
  (modify ?crohn-disease (score (+ ?score1 1)))
  (modify ?ulcerative-colitis (score (+ ?score2 6)))
  (modify ?symptom (activated TRUE)) 
)

;;ANEMIA 
(defrule anemia
  ?ulcerative-colitis <-(disease (name ulcerative-colitis) (score ?score1))
  ?celiac-disease <-(disease (name celiac-disease) (score ?score2))
  ?symptom<-(symptom (name anemia) (activated FALSE) (present YES)
)
  =>
  (modify ?ulcerative-colitis (score (+ ?score1 3)))
  (modify ?celiac-disease (score (+ ?score2 2 )))
  (modify ?symptom (activated TRUE)) 
)

;;CONSTIPATION 
(defrule constipation
  ?celiac-disease <-(disease (name celiac-disease) (score ?score1))
  ?symptom<-(symptom (name constipation) (activated FALSE) (present YES))
  =>
  (modify ?celiac-disease (score (+ ?score1  7)))
  (modify ?symptom (activated TRUE)) 
)

;;GAS 
(defrule gas
  ?celiac-disease <-(disease (name celiac-disease) (score ?score1))
  ?symptom<-(symptom (name gas) (activated FALSE) (present YES))
  =>
  (modify ?celiac-disease (score (+ ?score1  7)))
  (modify ?symptom (activated TRUE)) 
)

;;REGURGITATION
(defrule regurgitation
  ?erge <-(disease (name erge) (score ?score1))
  ?symptom<-(symptom (name regurgitation) (activated FALSE) (present YES))
  =>
  (modify ?erge (score (+ ?score1 7)))
  (modify ?symptom (activated TRUE)) 
)

;;DERMATITIS-HERPETIFORMIS
(defrule dermatitis-herpetiformis
  ?celiac-disease <-(disease (name celiac-disease) (score ?score1))
  ?symptom<-(symptom (name dermatitis-herpetiformis) (activated FALSE) (present YES))
  =>
  (modify ?celiac-disease (score (+ ?score1  2)))
  (modify ?symptom (activated TRUE)) 
)

;;APHTHOUS-STOMATITI
(defrule aphthous-stomatiti
	?celiac-disease <-(disease (name celiac-disease) (score ?score1))
	?erge <-(disease (name erge) (score ?score2))
	?symptom<-(symptom (name aphthous-stomatiti) (activated FALSE) (present YES))
	=>
	(modify ?celiac-disease (score (+ ?score1  1)))
	(modify ?erge (score (+ ?score2  2)))
	(modify ?symptom (activated TRUE)) 
)


;;PRINT DISEASES

;;PRINT DISEASES WITH SCORE HIGHER THAN ZERO
(defrule print-scores-higher
	(declare (salience -400))
	?disease <- (disease (name ?name) (score ?score) (total ?total))
	(test (> (/ ?score ?total) 0))
	=>
	(printout t (/ ?score ?total)  "  " ?name crlf)

)

;;PRINT DISEASES WITH SCORE LOWER THAN ZERO OR EQUAL
(defrule print-scores-lower
	(declare (salience -500))
	?disease <- (disease (name ?name) (score ?score) (total ?total))
	(test (or (< (/ ?score ?total) 0) (= (/ ?score ?total) 0)))
	=>
	(printout t  "0  " ?name crlf)
)




(ns tinn.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[tinn started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[tinn has shut down successfully]=-"))
   :middleware identity})

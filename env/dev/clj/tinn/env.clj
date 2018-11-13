(ns tinn.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [tinn.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[tinn started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[tinn has shut down successfully]=-"))
   :middleware wrap-dev})

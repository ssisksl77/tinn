(ns tinn.routes.home
  (:require [tinn.layout :as layout]
            [tinn.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [hiccup.core :as hc]))

(def test-notes
  [{:title "title11111" :desc "desc11111"}
   {:title "title22222" :desc "desc22222"}
   {:title "title33333" :desc "desc33333"}
   {:title "title44444" :desc "desc44444"}
   {:title "title55555" :desc "desc55555"}])


(defn notes-page [notes]
  (hc/html  [:div [:h1 "hi this is notes-page"]
             [:ul
              (for [note notes]
                (let [{:keys [title desc]} note]
                  [:li "title : " title ", desc : " desc]))
              ]]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/notes" [] (notes-page test-notes))
  (GET "/about" [] (about-page)))

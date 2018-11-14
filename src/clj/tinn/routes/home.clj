(ns tinn.routes.home
  (:require [tinn.layout :as layout]
            [tinn.db.core :as db]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [hiccup.core :as hc]
            [compojure.route :as route]))

(def test-notes
  [{:title "title11111" :desc "desc11111" :author "yuhnam"}
   {:title "title22222" :desc "desc22222" :author "yuhanm"}
   {:title "title33333" :desc "desc33333" :author "Hall"}
   {:title "title44444" :desc "desc44444" :author "Stive"}
   {:title "title55555" :desc "desc55555" :author "Kim"}])


(defn notes-to-html [notes]
  (hc/html  [:div {:class "container"} [:h1 "See your Notes"]
             [:ul
              (for [note notes]
                (let [{:keys [title desc author]} note]
                  [:li "title : " title ", desc : " desc ", author: " author]))
              ]]))

(defn notes-page [notes]
  (layout/render
   "notes.html" {:notes notes}))

(defn home-page-backup []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn home-page []
  (hc/html [:a {:href "/notes"} "see your notes"]))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/notes" [] (notes-page test-notes))
  (GET "/about" [] (about-page))
  (route/not-found (hc/html [:h1 "page not found"])))


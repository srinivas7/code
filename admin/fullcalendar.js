$(function(){
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay',
            ignoreTimezone: false
        },
        selectable: true,
        selectHelper: true,
        editable: true,
        events: 'events'
    });
    
    
    var Event = Backbone.Model.extend();
    
    var Events = Backbone.Collection.extend({
        model: Event,
        url: 'events'
    });
 
    var EventsView = Backbone.View.extend({
        initialize: function(){
            _.bindAll(this);
 
            this.collection.bind('reset', this.addAll);
        },
        render: function() {
            this.el.fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,basicWeek,basicDay',
                    ignoreTimezone: false
                },
                selectable: true,
                selectHelper: true,
                editable: true
            });
        },
        addAll: function(){
            this.el.fullCalendar('addEventSource', this.collection.toJSON());
        }
    });
 
    var events = new Events();
    new EventsView({el: $("#calendar"), collection: events}).render();
    events.fetch();
});
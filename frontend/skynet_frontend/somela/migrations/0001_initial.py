# encoding: utf-8
import datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models

class Migration(SchemaMigration):

    def forwards(self, orm):
        
        # Adding model 'DoesItWorkModel'
        db.create_table('somela_doesitworkmodel', (
            ('id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('is_working', self.gf('django.db.models.fields.BooleanField')(default=False)),
            ('migration_worked', self.gf('django.db.models.fields.BooleanField')(default=False)),
        ))
        db.send_create_signal('somela', ['DoesItWorkModel'])


    def backwards(self, orm):
        
        # Deleting model 'DoesItWorkModel'
        db.delete_table('somela_doesitworkmodel')


    models = {
        'somela.doesitworkmodel': {
            'Meta': {'object_name': 'DoesItWorkModel'},
            'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'is_working': ('django.db.models.fields.BooleanField', [], {'default': 'False'}),
            'migration_worked': ('django.db.models.fields.BooleanField', [], {'default': 'False'})
        }
    }

    complete_apps = ['somela']
